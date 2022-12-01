package Library.System.Borrowings.web;



import Library.System.Borrowings.service.BorrowingsService;
import Library.System.Borrowings.service.dtos.BorrowingsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowings")
public class BorrowingsController {
    @Autowired
    BorrowingsService borrowingsService;

    @PostMapping
    public ResponseEntity<?> addBorrowings(@RequestBody BorrowingsDto borrowingsDto){
        borrowingsService.add(borrowingsDto);
        return  new ResponseEntity<>(borrowingsDto, HttpStatus.OK);
    }

    @DeleteMapping("/{borrowingNumber}")
    public ResponseEntity<?> deleteBorrowings(@PathVariable long borrowingNumber){
        borrowingsService.deleteByBorrowingNumber(borrowingNumber);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{borrowingNumber}")
    public ResponseEntity<?> updateBorrowings(@PathVariable long borrowingNumber,@RequestBody BorrowingsDto borrowingsDto){
        borrowingsService.updateByBorrowingNumber(borrowingNumber,borrowingsDto);
        return  new ResponseEntity<>(borrowingNumber, HttpStatus.OK);
    }

    @GetMapping("/{borrowingNumber}")
    public ResponseEntity<?> getBorrowing(@PathVariable long borrowingNumber){
       BorrowingsDto borrowingsDto = borrowingsService.getBorrowingsByBorrowingNumber(borrowingNumber);
        return  new ResponseEntity<>(borrowingsDto, HttpStatus.OK);
    }



}
