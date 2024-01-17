//: jdbc.controller.PurchaseController.java


package jdbc.controller;


import jdbc.domain.model.Purchase;
import jdbc.repository.PurchaseRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    @GetMapping()
    ResponseEntity<?> allPurchase() {
        return ResponseEntity.ok(this.purchaseRepository.findAll());
    }

    @PostMapping
    void savePurchase(@NonNull @RequestBody final Purchase purchase) {
        this.purchaseRepository.save(purchase);
    }

}///:~