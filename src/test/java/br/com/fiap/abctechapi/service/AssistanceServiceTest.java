package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.controller.model.Assistance;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AssistanceServiceTest {

    @Mock
    private AssistanceRepository assistanceRepository;
    private AssistanceService assistanceService;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImpl(assistanceRepository);
    }
    @DisplayName("Listando assistencias disponiveis :: Sucesso")
    @Test
    public void list_success(){
        Assistance assistance1 = new Assistance(1L, "Mock Assistance 1", "Description 1");
        Assistance assistance2 = new Assistance(2L, "Mock Assistance 2", "Description 2");
        Assistance assistance3 = new Assistance(3L, "Mock Assistance 3", "Description 3");
        Assistance assistance4 = new Assistance(4L, "Mock Assistance 4", "Description 4");
        Assistance assistance5 = new Assistance(5L, "Mock Assistance 5", "Description 5");
        Assistance assistance6 = new Assistance(6L, "Mock Assistance 6", "Description 6");

        when(assistanceRepository.findAll()).thenReturn(List.of(assistance1, assistance2, assistance3, assistance4, assistance5, assistance6));

        List<Assistance> values = assistanceService.getAssistanceList();

        Assertions.assertEquals(6, values.size());
        Assertions.assertSame(values.get(0), assistance1);
        Assertions.assertSame(values.get(1), assistance2);
        Assertions.assertSame(values.get(2), assistance3);
        Assertions.assertSame(values.get(3), assistance4);
        Assertions.assertSame(values.get(4), assistance5);
        Assertions.assertSame(values.get(5), assistance6);
    }

    @DisplayName("Listando assistencias indisponíveis :: Erro")
    @Test
    public void list_error(){

        when(assistanceRepository.findAll()).thenReturn(List.of());

        List<Assistance> values = assistanceService.getAssistanceList();
        Assertions.assertEquals(0, values.size());

    }
}
