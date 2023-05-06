package course.work.database.controller.model;

import course.work.database.model.Product;
import course.work.database.model.ReceiptProduct;
import course.work.database.service.ProductService;
import course.work.database.service.ReceiptProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/receiptProduct")  //TODO фронт
public class ReceiptProductController {

    @Autowired
    private ReceiptProductService service;


    @GetMapping("getAll")
    public String getAllReceiptProduct(Model model) {
        model.addAttribute("receiptProduct", service.getAll());
        return "showAllEmployees";
    }
    @GetMapping("addNewReceiptProduct")
    public String addReceiptProduct(Model model) {
        ReceiptProduct receiptProduct = new ReceiptProduct();
        model.addAttribute("receiptProduct", receiptProduct);
        return "newEmployee";
    }

    @PostMapping("save")
    public String saveReceiptProduct(@ModelAttribute("receiptProduct") ReceiptProduct receiptProduct) {
        service.save(receiptProduct);
        return "redirect:/boss/getAllEmployees";
    }

    @GetMapping("showReceiptProductByIdForUpdate/{id}")
    public String showProductByIdForUpdate(@PathVariable long id, Model model) {
        ReceiptProduct receiptProduct = service.getByID(id);
        model.addAttribute("receiptProduct", receiptProduct);
        return "update";
    }

    @DeleteMapping("deleteReceiptProductById/{id}")
    public String deleteReceiptProductById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
