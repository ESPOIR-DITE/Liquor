package controller.cashierFactory;
import controller.ControllerInt;
import domain.cashierBuilderPack.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.Cashier.impl.CashierServicer;

import java.util.ArrayList;
@RestController
public class CashierController implements ControllerInt<Cashier,String> {
    @Autowired
    private CashierServicer cashierServicer;

    @PostMapping("/create")
    @Override
    public Cashier create(@RequestBody Cashier cashier) {
        return cashierServicer.create(cashier);
    }

    @GetMapping("/read")
    @Override
    public Cashier read(@RequestParam(value = "id")String id) {
        return cashierServicer.read(id);
    }

    @GetMapping("/delete")
    @Override
    public void delete(@RequestParam(value = "id") String id) {

    }

    @PostMapping("/update")
    @Override
    public Cashier update(@RequestBody Cashier cashier) {
        return null;
    }

    @GetMapping("/reads")
    @Override
    public ArrayList<Cashier> readAll() {
        return null;
    }
}