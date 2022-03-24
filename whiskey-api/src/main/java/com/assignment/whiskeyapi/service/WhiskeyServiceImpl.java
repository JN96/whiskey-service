package com.assignment.whiskeyapi.service;

import com.assignment.whiskeyapi.exceptions.ExceptionHandler;
import com.assignment.whiskeyapi.exceptions.WhiskeyServiceException;
import com.assignment.whiskeyapi.implementation.WhiskeyController;
import com.assignment.whiskeyapi.models.Whiskey;
import com.assignment.whiskeyapi.repository.WhiskeyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class WhiskeyServiceImpl implements WhiskeyController {

    @Autowired
    private WhiskeyRepository whiskeyRepository;

    @Autowired
    private ExceptionHandler exceptionHandler;

    private static final Logger logger = LoggerFactory.getLogger(WhiskeyServiceImpl.class);

    public List<Whiskey> getWhiskeys(final String name, final String category) throws WhiskeyServiceException {
        try {
            if (name != null) {
                logger.info("Retrieving whiskeys by name {}.", name);
                return whiskeyRepository.findAllByName(name);
            } else if (category != null) {
                logger.info("Retrieving whiskeys by category {}.", category);
                return whiskeyRepository.findAllByCategory(category);
            } else {
                logger.info("Retrieving all whiskeys.");
                return (List<Whiskey>) whiskeyRepository.findAll();
            }
        } catch (final Exception e) {
            logger.info("Unable to find whiskey(s): {}", e.getMessage());
            throw exceptionHandler.createServiceException(HttpStatus.NOT_FOUND, "getWhiskeys", "Unable to find whiskey(s).", e);
        }
    }

    public Optional<Whiskey> getWhiskeyById(final Integer id) throws WhiskeyServiceException {
        try {
            final Optional<Whiskey> whiskey = whiskeyRepository.findById(id);
            logger.info("Whiskey {} was successfully found.", whiskey.get().getId());
            return whiskey;
        } catch (final NoSuchElementException e) {
            logger.info("Unable to find whiskey {}: {}", id, e.getMessage());
            throw exceptionHandler.createServiceException(HttpStatus.NOT_FOUND, "getWhiskeyById", "Unable to find whiskey.", e);
        }
    }

    public void createWhiskey(final Whiskey whiskey) throws WhiskeyServiceException {
        try {
            final Whiskey newWhiskey = new Whiskey(whiskey);
            whiskeyRepository.save(newWhiskey);
            logger.info("{} {} was successfully created.", newWhiskey.getName(), newWhiskey.getOptionalName());
        } catch (final TransactionSystemException | DataIntegrityViolationException e) {
            logger.info("Unable to create whiskey: {}", e.getMessage());
            throw exceptionHandler.createServiceException(HttpStatus.BAD_REQUEST, "createWhiskey", "Unable to create whiskey.", e);
        }
    }

    public void updateWhiskey(final Integer id, final Whiskey whiskey) throws WhiskeyServiceException {
        try {
            final Optional<Whiskey> whiskeyToUpdate = getWhiskeyById(id);
            whiskeyRepository.save(whiskey);
            logger.info("Whiskey {} was successfully updated.", whiskeyToUpdate.get().getId());
        } catch (final TransactionSystemException | NoSuchElementException | DataIntegrityViolationException e) {
            logger.info("Unable to update whiskey: {}", e.getMessage());
            throw exceptionHandler.createServiceException(HttpStatus.NOT_FOUND, "updateWhiskey", "Unable to update whiskey.", e);
        }
    }

    public void deleteWhiskey(final Integer id) throws WhiskeyServiceException {
        try {
            final Optional<Whiskey> whiskeyToDelete = whiskeyRepository.findById(id);
            whiskeyRepository.deleteById(id);
            logger.info("Whiskey {} {} was successfully deleted.", whiskeyToDelete.get().getName(), whiskeyToDelete.get().getOptionalName());
        } catch (final NoSuchElementException | EmptyResultDataAccessException e) {
            logger.info("Unable to delete whiskey: {}", e.getMessage());
            throw exceptionHandler.createServiceException(HttpStatus.NOT_FOUND, "deleteWhiskey", "Unable to delete whiskey.", e);
        }
    }

}
