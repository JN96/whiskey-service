package com.assignment.whiskeyapi.implementation;

import com.assignment.whiskeyapi.exceptions.WhiskeyServiceException;
import com.assignment.whiskeyapi.models.Whiskey;

import java.util.List;
import java.util.Optional;

public interface WhiskeyController {

    /**
     * Get all whiskies.
     * Get all whiskies based on name.
     * Get all whiskies based on category.
     * @param name - the name of the whiskey
     * @param category - the category of the whiskey
     * @return List<Whiskey>
     * @throws WhiskeyServiceException
     */
    List<Whiskey> getWhiskeys(final String name, final String category) throws WhiskeyServiceException;

    /**
     * Get whiskey based on its id.
     * @param id - the id of the whiskey
     * @return Optional<Whiskey>
     * @throws WhiskeyServiceException
     */
    Optional<Whiskey> getWhiskeyById(final Integer id)  throws WhiskeyServiceException;

    /**
     * Create a whiskey.
     * @param whiskey - the whiskey details
     * @throws WhiskeyServiceException
     */
    void createWhiskey(final Whiskey whiskey) throws WhiskeyServiceException;

    /**
     * Update a whiskey by its id with details in the request body.
     * @param id - the id of the whiskey
     * @param whiskey - the whiskey details
     * @throws WhiskeyServiceException
     */
    void updateWhiskey(final Integer id, final Whiskey whiskey) throws WhiskeyServiceException;

    /**
     * Delete a whiskey based on its id.
     * @param id - the id of the whiskey
     * @throws WhiskeyServiceException
     */
    void deleteWhiskey(final Integer id) throws WhiskeyServiceException;

}
