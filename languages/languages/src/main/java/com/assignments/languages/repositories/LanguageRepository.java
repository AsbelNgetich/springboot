package com.assignments.languages.repositories;



import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.assignments.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	//retrieves all Languages
	List<Language> findAll();
}
