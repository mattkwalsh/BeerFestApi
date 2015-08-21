package com.walsh.web.controller;

import com.google.common.collect.Lists;
import com.walsh.web.data.BeerFestivalDao;
import com.walsh.web.model.BeerFestival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller mapping all requests used when reading information about about beer festivals
 */
@RestController
public class BeerFestController {

    private BeerFestivalDao beerFestivalDao;

    @Autowired
    public BeerFestController(BeerFestivalDao beerFestivalDao) {
        this.beerFestivalDao = beerFestivalDao;
    }

    /**
     * Looks up every {@link com.walsh.web.model.BeerFestival} and returns it
     *
     * @return A list of all beer festivals, empty if none are found
     */
    @RequestMapping("/festivals")
    public List<BeerFestival> getAllFests() {
        return beerFestivalDao.getAllFestivals();
    }

    /**
     * Returns a {@link com.walsh.web.model.BeerFestival}, as specified by the incoming id. This will return a 400 if
     * the id parameter is not set, and a 404 if a festival is not found
     * @param id Festival Id
     * @return A BeerFestival
     */
    @RequestMapping("/festival")
    public BeerFestival getFestival(@RequestParam(value = "id") Long id) {
        if (id == null) {
            throw new IdNotPresentException();
        }
        BeerFestival festival = beerFestivalDao.getFestival(id);
        if (festival == null) {
            throw new FestivalNotFoundException();
        }
        return festival;
    }

    /**
     * Returns a count of the number of festivals
     * @return A count of the number of festivals
     */
    @RequestMapping("/festivalCount")
    public Integer getFestivalCount() {
        return getAllFests().size();
    }
}
