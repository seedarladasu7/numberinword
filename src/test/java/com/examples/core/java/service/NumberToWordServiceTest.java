package com.examples.core.java.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
 

@RunWith(SpringRunner.class)
public class NumberToWordServiceTest {

    @InjectMocks
    private NumberToWordService numberToWordService;

    @Mock
    NumberToEnglishWords numberToEnglishWords;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
	public void testGetNumberInWord() throws Exception {
		String numStr = "56945781";
		String mockResp = "fifty six million nine hundred and forty five thousand seven hundred and eighty one";
	    Mockito.when(numberToWordService.getNumberInWord(numStr)).thenReturn(mockResp);
	}
    
	@Test
    public void testConvert() throws Exception {
		long number = 56945781l;
		String mockResp = "fifty six million nine hundred and forty five thousand seven hundred and eighty one";
	    Mockito.when(numberToEnglishWords.convert(number)).thenReturn(mockResp);	
    }
	
	@Test
	public void testConvertLessThanOneThousand() throws Exception {
		int number = 56945781;
		String mockResp = "";
	    Mockito.when(numberToEnglishWords.convertLessThanOneThousand(number)).thenReturn(mockResp);
	}
}