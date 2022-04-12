package com.assignment.whiskeyapi.rest;

import com.assignment.whiskeyapi.exceptions.ExceptionHandler;
import com.assignment.whiskeyapi.exceptions.WhiskeyServiceException;
import com.assignment.whiskeyapi.implementation.WhiskeyController;
import com.assignment.whiskeyapi.models.Whiskey;
import com.assignment.whiskeyapi.response.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class WhiskeyRestResource {

    @Autowired
    private WhiskeyController whiskeyController;

    @Autowired
    private ExceptionHandler exceptionHandler;

    @Autowired
    private ResponseHandler responseHandler;

    private static final Logger logger = LoggerFactory.getLogger(WhiskeyRestResource.class);

    /**
     * Returns all available whiskeys.
     *
     * @return ResponseEntity - List<WhiskeyDTO>
     */
    @GetMapping("/whiskeys")
    public ResponseEntity getAllWhiskies(@RequestParam(value = "name", required = false) final String name, @RequestParam(value = "category", required = false) final String category) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(whiskeyController.getWhiskeys(name, category));
        } catch (final WhiskeyServiceException  e) {
            return exceptionHandler.handleException(e);
        }
    }

    /**
     * Retrieves a single whiskey based on the id.
     *
     * @param id - the name of the whiskey
     * @return ResponseEntity - Whiskey
     */
    @GetMapping("/whiskeys/{id}")
    public ResponseEntity getWhiskeyById(@PathVariable("id") final Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(whiskeyController.getWhiskeyById(id));
        } catch (final WhiskeyServiceException e) {
            return exceptionHandler.handleException(e);
        }
    }

    /**
     * Add a new whiskey to the service.
     *
     * @param whiskey - the details of the new whiskey
     */
    @PostMapping("/whiskeys")
    public ResponseEntity createWhiskey(@RequestBody final Whiskey whiskey) {
        try {
            whiskeyController.createWhiskey(whiskey);
            return responseHandler.handleResponse(HttpStatus.CREATED, "Whiskey was successfully created.");
        } catch (final WhiskeyServiceException e) {
            return exceptionHandler.handleException(e);
        }
    }

    /**
     * Update the information of an existing whiskey.
     *
     * @param whiskey - the details of the whiskey to update
     */
    @PutMapping("/whiskeys/{id}")
    public ResponseEntity updateWhiskey(@PathVariable("id") final Integer id, @RequestBody final Whiskey whiskey) {
        try {
            whiskeyController.updateWhiskey(id, whiskey);
            return responseHandler.handleResponse(HttpStatus.CREATED, "Whiskey was successfully updated.");
        } catch (final WhiskeyServiceException e) {
            return exceptionHandler.handleException(e);
        }
    }

    /**
     * Delete a whiskey based on the id.
     *
     * @param id - the id of the whiskey
     */
    @DeleteMapping("/whiskeys/{id}")
    public ResponseEntity deleteWhiskey(@PathVariable("id") final Integer id) {
        try {
            whiskeyController.deleteWhiskey(id);
            return responseHandler.handleResponse(HttpStatus.OK, "Whiskey was successfully deleted.");
        } catch (final WhiskeyServiceException e) {
            return exceptionHandler.handleException(e);
        }
    }
}
