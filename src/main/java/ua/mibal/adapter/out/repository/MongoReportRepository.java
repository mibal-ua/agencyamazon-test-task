package ua.mibal.adapter.out.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ua.mibal.domain.Report;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public interface MongoReportRepository extends MongoRepository<Report, ObjectId> {
}
