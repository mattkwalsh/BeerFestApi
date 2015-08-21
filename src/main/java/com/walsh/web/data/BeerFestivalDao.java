package com.walsh.web.data;

import com.walsh.web.model.Beer;
import com.walsh.web.model.BeerFestival;

import java.util.List;

/**
 * Data access object for {@link com.walsh.web.model.BeerFestival}
 */
public interface BeerFestivalDao {

    /**
     * Retrieves a festival based on its ID
     *
     * @param id ID of festival to retrieve
     * @return BeerFestival, null if ID is not found
     */
    public BeerFestival getFestival(Long id);

    /**
     * Returns all festivals
     *
     * @return A list of all festivals, an empty list if no festivals are found
     */
    public List<BeerFestival> getAllFestivals();
}
