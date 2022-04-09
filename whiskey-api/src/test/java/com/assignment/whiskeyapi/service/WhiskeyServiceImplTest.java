package com.assignment.whiskeyapi.service;

import com.assignment.whiskeyapi.exceptions.WhiskeyServiceException;
import com.assignment.whiskeyapi.models.Whiskey;
import com.assignment.whiskeyapi.repository.WhiskeyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WhiskeyServiceImplTest {

    private static final Whiskey jamesonWhiskey = new Whiskey(1, "Jameson", "Original", "Ireland", "Irish", 25.00, "");
    private static final Whiskey bulleitBourbonWhiskey = new Whiskey(2, "Bulleit Bourbon", "Rye", "USA", "Bourbon", 45.00, "");
    private static final Whiskey lagavulinWhiskey = new Whiskey(3, "Lagavulin", "12 Years Old", "Scotland", "Scotch", 60.00, "");
    private static final Whiskey redbreastWhiskey = new Whiskey(4, "Redbreast", "12 Years Old", "Ireland", "Irish", 60.00, "");
    private static final Whiskey redbreastWhiskeyToUpdate = new Whiskey(4, "Redbreast", "12 Years Old", "Ireland", "Irish", 60.00, "Made from a mash of malted and unmalted barley and then triple distilled in copper pot stills, Redbreast 12 boasts the flavour complexity and distinctive qualities of Pot Still whiskey. Matured in a combination of Bourbon seasoned American Oak barrels and Oloroso Sherry seasoned Spanish oak butts, the distinctive Redbreast sherry style is a joy to behold in each and every bottle.");

    private static final List<Whiskey> whiskeyList = new ArrayList<>(Arrays.asList(jamesonWhiskey, bulleitBourbonWhiskey, lagavulinWhiskey));

    @Mock
    private WhiskeyRepository whiskeyRepository;

    @InjectMocks
    private WhiskeyServiceImpl whiskeyService;

    @Test
    public void shouldGetWhiskeys() throws WhiskeyServiceException {
        when(whiskeyRepository.findAll()).thenReturn(whiskeyList);
        List<Whiskey> actual = whiskeyService.getWhiskeys(null, null);
        assertEquals(actual, whiskeyList);
    }

    @Test
    public void shouldGetWhiskeysByName() throws WhiskeyServiceException {
        when(whiskeyRepository.findAllByName(jamesonWhiskey.getName())).thenReturn(new ArrayList<>(Arrays.asList(jamesonWhiskey)));
        List<Whiskey> actual = whiskeyService.getWhiskeys(jamesonWhiskey.getName(), null);
        assertEquals(actual.get(0), jamesonWhiskey);
    }

    @Test
    public void shouldGetWhiskeysByCategory() throws WhiskeyServiceException {
        when(whiskeyRepository.findAllByCategory(jamesonWhiskey.getCategory())).thenReturn(new ArrayList<>(Arrays.asList(jamesonWhiskey)));
        List<Whiskey> actual = whiskeyService.getWhiskeys(null, jamesonWhiskey.getCategory());
        assertEquals(actual.get(0), jamesonWhiskey);
    }

    @Test
    public void shouldGetWhiskeysById() throws WhiskeyServiceException {
        when(whiskeyRepository.findById(jamesonWhiskey.getId())).thenReturn(Optional.of(jamesonWhiskey));
        Optional<Whiskey> actual = whiskeyService.getWhiskeyById(jamesonWhiskey.getId());
        assertEquals(actual.get(), jamesonWhiskey);
    }

    @Test
    public void shouldCreateWhiskey() throws WhiskeyServiceException {
        whiskeyService.createWhiskey(redbreastWhiskey);
        verify(whiskeyRepository, times(1)).save(any(Whiskey.class));
    }

    @Test
    public void shouldUpdateWhiskey() throws WhiskeyServiceException {
        when(whiskeyRepository.findById(redbreastWhiskey.getId())).thenReturn(Optional.of(redbreastWhiskey));
        whiskeyService.updateWhiskey(redbreastWhiskey.getId(), redbreastWhiskeyToUpdate);
        verify(whiskeyRepository, times(1)).save(redbreastWhiskeyToUpdate);
    }

    @Test
    public void shouldDeleteWhiskey() throws WhiskeyServiceException {
        when(whiskeyRepository.findById(redbreastWhiskey.getId())).thenReturn(Optional.of(redbreastWhiskey));
        whiskeyService.deleteWhiskey(redbreastWhiskey.getId());
        verify(whiskeyRepository, times(1)).deleteById(redbreastWhiskeyToUpdate.getId());
    }

    @Test
    public void shouldThrowExceptions() {
        assertThrows(Exception.class, () -> whiskeyService.getWhiskeyById(0));

        assertThrows(Exception.class, () -> whiskeyService.deleteWhiskey(0));
    }
}
