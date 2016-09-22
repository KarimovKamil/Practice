package ru.itis.inform.Controllers;

import com.google.common.collect.Lists;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.itis.inform.Services.CarsService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.itis.inform.Dao.CarsDaoData.CAR_1;
import static ru.itis.inform.Dao.CarsDaoData.CAR_2;


public class ControllerTest {

    @Mock
    private CarsService carsService;

    @InjectMocks
    private Controller controller;

    private MockMvc mvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(carsService.getCarInfo(1)).thenReturn(CAR_1);
        when(carsService.getTable()).thenReturn(Lists.newArrayList(CAR_1, CAR_2));
    }

    @Test
    public void carInfo() throws Exception {
        mvc.perform(get("/info?id=1", CAR_1.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(CAR_1.toString()));
    }

    @Test
    public void carTable() throws Exception {
        mvc.perform(get("/table").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", Is.is(CAR_1.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].mark", Is.is(CAR_1.getMark())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].releaseDate", Is.is(CAR_1.getReleaseDate())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].numberplate", Is.is(CAR_1.getNumberplate())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].carOwner", Is.is(CAR_1.getCarOwner())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id", Is.is(CAR_2.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].mark", Is.is(CAR_2.getMark())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].releaseDate", Is.is(CAR_2.getReleaseDate())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].numberplate", Is.is(CAR_2.getNumberplate())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].carOwner", Is.is(CAR_2.getCarOwner())));
    }

}