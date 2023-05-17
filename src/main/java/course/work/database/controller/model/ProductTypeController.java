package course.work.database.controller.model;

import course.work.database.model.ProductType;
import course.work.database.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productType")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class ProductTypeController {

    @Autowired
    private ProductTypeService service;


    @GetMapping("getAll")
    public String getAllProductType(Model model) {
        model.addAttribute("productTypes", service.getAll());
        return "showAll/showAllProductType";
    }
    @GetMapping("addNewProductType")
    public String addProductType(Model model) {
        ProductType productType = new ProductType();
        model.addAttribute("productType", productType);
        return "updateObject/updateProductType";
    }

    @PostMapping("save")
    public String saveProductType(@ModelAttribute("productType") ProductType productType) {
        service.save(productType);
        return "redirect:/productType/getAll";
    }

    @GetMapping("showProductTypeByIdForUpdate/{id}")
    public String showProductTypeByIdForUpdate(@PathVariable long id, Model model) {
        ProductType productType = service.getByID(id);
        model.addAttribute("productType", productType);
        return "updateObject/updateProductType";
    }

    @DeleteMapping("deleteProductTypeById/{id}")
    public String deleteProductTypeById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/productType/getAll";
    }
}
