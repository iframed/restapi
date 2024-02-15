package com.example.backagency.testrepo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.backagency.model.Model;
import com.example.backagency.repo.Repo;
import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class testRepo {
    
    @Autowired
    private Repo repo;

    @Test
    public void testSaveModel() {
        // Création d'un objet Model pour le test
        Model model = new Model();
        model.setFirsname("John");
        model.setLastname("Doe");
        // Enregistrer le modèle dans la base de données
        Model savedModel = repo.save(model);
        // Vérifier que le modèle enregistré est non null
        assertThat(savedModel).isNotNull();
        // Vérifier que l'ID du modèle enregistré est non null
        assertThat(savedModel.getId()).isNotNull();
        // Vérifier que les attributs du modèle enregistré correspondent aux valeurs attendues
        assertThat(savedModel.getFirsname()).isEqualTo("John");
        assertThat(savedModel.getLastname()).isEqualTo("Doe");
    }

    @Test
    public void testFindAllModels() {
        // Création de plusieurs objets Model pour le test
        Model model1 = new Model();
        model1.setFirsname("Alice");
        model1.setLastname("Smith");
        Model model2 = new Model();
        model2.setFirsname("Bob");
        model2.setLastname("Jones");
        // Enregistrer les modèles dans la base de données
        repo.save(model1);
        repo.save(model2);
        // Récupérer tous les modèles de la base de données
        List<Model> allModels = repo.findAll();
        // Vérifier que la liste des modèles récupérés n'est pas vide
        assertThat(allModels).isNotEmpty();
        // Vérifier que la taille de la liste correspond au nombre de modèles enregistrés
        assertThat(allModels.size()).isEqualTo(24);
    }

}
