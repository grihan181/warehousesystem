package course.work.database.controller.model;

import course.work.database.model.Batch;
import course.work.database.model.Product;
import course.work.database.service.BatchService;
import course.work.database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("getAll")
    public String getAllProduct(Model model) {
        model.addAttribute("products", service.getAll());
        return "showAll/showAllProduct";
    }
    /*@GetMapping("search")
    public String getSearchProduct(Model model) {
        model.addAttribute("products", service.searchAll());
        return "showAll/showAllProduct";
    }*/
    @GetMapping("addNewProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "updateObject/updateProduct";
    }

    @PostMapping("save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/product/getAll";
    }

    @GetMapping("showProductByIdForUpdate/{id}")
    public String showProductByIdForUpdate(@PathVariable long id, Model model) {
        Product product = service.getByID(id);
        model.addAttribute("product", product);
        return "updateObject/updateProduct";
    }

    @DeleteMapping("deleteProductById/{id}")
    public String deleteProductById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/product/getAll";
    }
}
