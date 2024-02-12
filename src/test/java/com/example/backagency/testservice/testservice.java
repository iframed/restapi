package com.example.backagency.testservice;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.backagency.model.Model;
import com.example.backagency.repo.Repo;

import com.example.backagency.service.ContactServiceimpl;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class testservice {
    
    // Création d'un mock pour le repo
    @Mock
    private Repo repoMock;

    // Injection des mocks dans le service à tester
    @InjectMocks
    private ContactServiceimpl contactServiceimpl;

    // Test de la méthode cree() du service
    @Test
    public void testCree() {
        // Création d'un objet Model pour le test
        Model model = new Model();
        model.setFirsname("John");
        model.setLastname("Doe");
        // Définir d'autres propriétés du modèle au besoin

        // Mock du comportement du repo pour retourner le modèle sauvegardé
        when(repoMock.save(model)).thenReturn(model);

        // Appeler la méthode du service pour créer un nouveau modèle
        Model savedModel = contactServiceimpl.cree(model);

        // Vérifier que le modèle retourné n'est pas null
        assertThat(savedModel).isNotNull();

        // Vérifier que les propriétés du modèle retourné correspondent aux valeurs attendues
        assertThat(savedModel.getFirsname()).isEqualTo(model.getFirsname());
        assertThat(savedModel.getLastname()).isEqualTo(model.getLastname());

        // Vérifier que le repo a été appelé une fois avec le bon argument
        verify(repoMock, times(1)).save(model);
    }

    
}
