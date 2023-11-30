package com.vehiclempg;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.vehiclempg.models.Vehicle;
import com.vehiclempg.repositories.VehicleRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.File;
import java.io.IOException;
import java.util.Map;


@Configuration
public class AppInitializer implements ServletContextInitializer {

    static Logger log = LogManager.getLogger(AppInitializer.class.getName());

    private VehicleRepository repository;

    private MongoTemplate mongoTemplate;

    public AppInitializer(VehicleRepository repository, MongoTemplate mongoTemplate)
    {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {

        if (mongoTemplate.getCollection("vehicle").countDocuments() > 0) {
            // we assume the app was previously initialized already
            return;
        }

        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);

        // retrieve csv file from /resources
        ClassLoader classLoader = getClass().getClassLoader();

        // initialize
        File csvFile;
        MappingIterator<Map.Entry> it;

        try {
            csvFile = new File(classLoader.getResource("data/vehicles.csv").getFile());
            it = mapper.readerFor(Vehicle.class).with(schema).readValues(csvFile);
        } catch (IOException | NullPointerException e) {
            log.error("Unable to find file.");
            return;
        }

        if (it.hasNext()) {
            it.next(); // skip header
        }

        while (it.hasNext()) {
            try {
                Vehicle vehicle = (Vehicle) it.next();

                repository.save(vehicle);
            } catch (Exception e) {
                // error saving a vehicle, continue
            }

        }
    }
}
