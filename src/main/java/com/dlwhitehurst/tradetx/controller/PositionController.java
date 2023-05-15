package com.dlwhitehurst.tradetx.controller;

import com.dlwhitehurst.tradetx.model.Position;
import com.dlwhitehurst.tradetx.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PositionController {

    @Autowired
    PositionRepository positionRepository;

    @GetMapping("/positions")
    public ResponseEntity<List<Position>> getAllPositions(@RequestParam(required = false) String symbol) {
        try {
            List<Position> positions = new ArrayList<>();

            if (symbol == null) {
                positions.addAll(positionRepository.findAll());
            } else {
                positions.addAll(positionRepository.findAllBySymbol(symbol));
            }

            if (positions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(positions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/positions/{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable("id") long id) {
        Optional<Position> positionData = positionRepository.findById(id);

        if (positionData.isPresent()) {
            return new ResponseEntity<>(positionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/positions")
    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
        try {
            Position _position = positionRepository
                    .save(position);
            return new ResponseEntity<>(_position, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/positions/{id}")
//    public ResponseEntity<Position> updatePosition(@PathVariable("id") long id, @RequestBody Position position) {
//        Optional<Position> positionData = positionRepository.findById(id);
//
//        if (positionData.isPresent()) {
//            Position _position = positionData.get();
//            _position.setId(position.getId());
//            _position.setTxDate(position.getTxDate());
//            _position.setTxId(position.getTxId());
//            _position.setTxDescription(position.getTxDescription());
//            _position.setTxQuantity(position.getTxQuantity());
//            _position.setTxSymbol(position.getTxSymbol());
//            _position.setTxPrice(position.getTxPrice());
//            _position.setTxCommission(position.getTxCommission());
//            _position.setTxAmount(position.getTxAmount());
//            _position.setTxRegFee(position.getTxRegFee());
//            _position.setTxShortTermRdmFee(position.getTxShortTermRdmFee());
//            _position.setTxFundRedemptionFee(position.getTxFundRedemptionFee());
//            _position.setTxDeferredSalesCharge(position.getTxDeferredSalesCharge());
//
//            return new ResponseEntity<>(positionRepository.save(_position), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/positions/{id}")
    public ResponseEntity<HttpStatus> deletePosition(@PathVariable("id") long id) {
        try {
            positionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/positions")
    public ResponseEntity<HttpStatus> deleteAllPositions() {
        try {
            positionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
