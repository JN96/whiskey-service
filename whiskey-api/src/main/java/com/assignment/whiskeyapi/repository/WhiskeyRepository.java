package com.assignment.whiskeyapi.repository;

import com.assignment.whiskeyapi.models.Whiskey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskeyRepository extends JpaRepository<Whiskey, Integer> {

    /**
     * Find whiskeys by the category.
     * @param category - the category of the whiskeys
     * @return List<Whiskey>
     */
    List<Whiskey> findAllByCategory(final String category);

    /**
     * Find all whiskeys based on search parameters.
     * @param name - the name of the whiskeys
     * @return List<Whiskey>
     */
    List<Whiskey> findAllByName(final String name);

}
