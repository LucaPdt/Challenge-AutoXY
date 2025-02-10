package com.lucapdt.challenge.automobile;

import com.lucapdt.challenge.entity.Automobile;
import com.lucapdt.challenge.repository.AutomobileRepository;
import com.lucapdt.challenge.service.AutomobileServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AutomobileServiceTest {

    @Mock
    private AutomobileRepository automobileRepository;

    @InjectMocks
    private AutomobileServiceImpl automobileService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllTest(){
        List<Automobile> automobileList = List.of(
            new Automobile("Alfa Romeo", "Giulietta", "2.0 JTDM", 2011, 7500.00, "disponibile"),
            new Automobile("Fiat", "Panda", "2.0 JTDM", 2011, 7500.00, "disponibile")
        );

        Pageable pageable = PageRequest.of(0,2);
        Page<Automobile> page = new PageImpl<>(automobileList, pageable, automobileList.size());
        when(automobileRepository.findAll(pageable)).thenReturn(page);

        Page<Automobile> result = automobileService.findAll(0,2);

        assertThat(result).isNotNull();
        assertThat(result.getContent()).hasSize(2);
        assertThat(result.getContent()).containsExactlyElementsOf(automobileList);
    }

    @Test
    void findByIdTest(){

        Automobile auto = new Automobile("Fiat", "Panda", "2.0 JTDM", 2011, 7500.00, "disponibile");

        when(automobileRepository.findById(1)).thenReturn(Optional.of(auto));
        when(automobileRepository.findById(2)).thenReturn(Optional.empty());
        assertThat(automobileService.findById(1)).isEqualTo(auto);

        assertThatThrownBy(() -> automobileService.findById(2)).isInstanceOf(NoSuchElementException.class).hasMessage("Non e' stata trovata una automobile per l'id inserito");
    }

    @Test
    void saveTest(){

        Automobile auto = new Automobile("Fiat", "Panda", "2.0 JTDM", 2011, 7500.00, "disponibile");

        when(automobileRepository.save(auto)).thenReturn(auto);
        assertThat(automobileService.save(auto)).isEqualTo(auto);
    }
}
