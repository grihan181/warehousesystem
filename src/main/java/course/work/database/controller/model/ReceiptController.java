package course.work.database.controller.model;

import course.work.database.model.Receipt;
import course.work.database.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptService service;


    @GetMapping("getAll")
    public String getAllReceipt(Model model) {
        model.addAttribute("receipts", service.getAll());
        return "showAll/showAllReceipt";
    }
    @GetMapping("addNewReceipt")
    public String addReceipt(Model model) {
        Receipt receipt = new Receipt();
        model.addAttribute("receipt", receipt);
        return "newObject/newReceipt";
    }

    @PostMapping("save")
    public String saveReceipt(@ModelAttribute("receipt") Receipt receipt) {
        service.save(receipt);
        return "redirect:/receipt/getAll";
    }

    @GetMapping("showReceiptByIdForUpdate/{id}")
    public String showReceiptByIdForUpdate(@PathVariable long id, Model model) {
        Receipt receipt = service.getByID(id);
        model.addAttribute("receipt", receipt);
        return "updateObject/updateReceipt";
    }

    @DeleteMapping("deleteReceiptById/{id}")
    public String deleteReceiptById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/receipt/getAll";
    }
}
