package course.work.database.controller.model;

import course.work.database.model.Product;
import course.work.database.model.ProductType;
import course.work.database.service.ProductService;
import course.work.database.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productType")  //TODO фронт
public class ProductTypeController {

    @Autowired
    private ProductTypeService service;


    @GetMapping("getAll")
    public String getAllProductType(Model model) {
        model.addAttribute("ProductTypes", service.getAll());
        return "showAllEmployees";
    }
    @GetMapping("addNewProductType")
    public String addProductType(Model model) {
        ProductType productType = new ProductType();
        model.addAttribute("productType", productType);
        return "newEmployee";
    }

    @PostMapping("save")
    public String saveProductType(@ModelAttribute("productType") ProductType productType) {
        service.save(productType);
        return "redirect:/boss/getAllEmployees";
    }

    @GetMapping("showProductTypeByIdForUpdate/{id}")
    public String showProductTypeByIdForUpdate(@PathVariable long id, Model model) {
        ProductType productType = service.getByID(id);
        model.addAttribute("productType", productType);
        return "update";
    }

    @DeleteMapping("deleteProductTypeById/{id}")
    public String deleteProductTypeById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
