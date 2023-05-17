package course.work.database.service;

import course.work.database.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAll();
    void save (Product employeeWarehouse);
    Product getByID(long id);
    void deleteViaId(long id);

    List<Product> searchAllLike(String searchWord);

}
