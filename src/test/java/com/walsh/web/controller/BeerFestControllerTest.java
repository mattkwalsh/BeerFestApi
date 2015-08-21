package com.walsh.web.controller;

import com.walsh.web.data.BeerFestivalDao;
import com.walsh.web.model.BeerFestival;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link com.walsh.web.controller.BeerFestControllerTest}
 */
@RunWith(MockitoJUnitRunner.class)
public class BeerFestControllerTest {

    private static final Long FESTIVAL_ID = 6l;

    @Test
    public void testGetAllFestsNoneFound(){
        BeerFestivalDao mockedDao = mock(BeerFestivalDao.class);
        when(mockedDao.getAllFestivals()).thenReturn(new ArrayList<BeerFestival>());

        BeerFestController testController = new BeerFestController(mockedDao);
        List<BeerFestival> result =  testController.getAllFests();
        assertNotNull(result);
        assertEquals(0,result.size());
    }



    @Test
    public void testGetAllFestsSomeFound(){
        BeerFestivalDao mockedDao = mock(BeerFestivalDao.class);
        List<BeerFestival> beerFestivals = new ArrayList<>();
        BeerFestival fest = new BeerFestival("test");
        beerFestivals.add(fest);
        when(mockedDao.getAllFestivals()).thenReturn(beerFestivals);

        BeerFestController testController = new BeerFestController(mockedDao);
        List<BeerFestival> result =  testController.getAllFests();
        assertNotNull(result);
        assertEquals(1,result.size());
        assertNotNull(result.get(0));
    }

    @Test
    public void testGetFestivalFound(){
        BeerFestivalDao mockedDao = mock(BeerFestivalDao.class);
        BeerFestival fest = new BeerFestival("test");
        when(mockedDao.getFestival(anyLong())).thenReturn(fest);

        BeerFestController testController = new BeerFestController(mockedDao);
        BeerFestival result =  testController.getFestival(FESTIVAL_ID);
        assertNotNull(result);
    }

    @Test(expected = IdNotPresentException.class)
    public void testGetFestivalNullId(){
        BeerFestivalDao mockedDao = mock(BeerFestivalDao.class);
        BeerFestController testController = new BeerFestController(mockedDao);
        testController.getFestival(null);
    }

    @Test(expected = FestivalNotFoundException.class)
    public void testGetFestivalNotFound(){
        BeerFestivalDao mockedDao = mock(BeerFestivalDao.class);
        when(mockedDao.getFestival(anyLong())).thenReturn(null);

        BeerFestController testController = new BeerFestController(mockedDao);
        testController.getFestival(FESTIVAL_ID);
    }

    @Test
    public void testGetCountNoFestivals(){
        BeerFestivalDao mockedDao = mock(BeerFestivalDao.class);
        when(mockedDao.getAllFestivals()).thenReturn(new ArrayList<BeerFestival>());

        BeerFestController testController = new BeerFestController(mockedDao);
        int result =  testController.getFestivalCount();
        assertNotNull(result);
        assertEquals(0,result);

    }

    @Test
    public void testGetCountFound(){
        BeerFestivalDao mockedDao = mock(BeerFestivalDao.class);
        List<BeerFestival> beerFestivals = new ArrayList<>();
        BeerFestival fest = new BeerFestival("test");
        beerFestivals.add(fest);
        when(mockedDao.getAllFestivals()).thenReturn(beerFestivals);

        BeerFestController testController = new BeerFestController(mockedDao);
        int result =  testController.getFestivalCount();
        assertNotNull(result);
        assertEquals(1, result);
    }

}