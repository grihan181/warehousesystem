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
@RequestMapping("/receiptProduct")
public class ReceiptProductController {

    @Autowired
    private ReceiptProductService service;


    @GetMapping("getAll")
    public String getAllReceiptProduct(Model model) {
        model.addAttribute("receiptProducts", service.getAll());
        return "showAll/showAllReceiptProduct";
    }
    @GetMapping("addNewReceiptProduct")
    public String addReceiptProduct(Model model) {
        ReceiptProduct receiptProduct = new ReceiptProduct();
        model.addAttribute("receiptProduct", receiptProduct);
        return "newObject/newReceiptProduct";
    }

    @PostMapping("save")
    public String saveReceiptProduct(@ModelAttribute("receiptProduct") ReceiptProduct receiptProduct) {
        service.save(receiptProduct);
        return "redirect:/receiptProduct/getAll";
    }

    @GetMapping("showReceiptProductByIdForUpdate/{id}")
    public String showProductByIdForUpdate(@PathVariable long id, Model model) {
        ReceiptProduct receiptProduct = service.getByID(id);
        model.addAttribute("receiptProduct", receiptProduct);
        return "updateObject/updateReceiptProduct";
    }

    @DeleteMapping("deleteReceiptProductById/{id}")
    public String deleteReceiptProductById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/receiptProduct/getAll";
    }
}
