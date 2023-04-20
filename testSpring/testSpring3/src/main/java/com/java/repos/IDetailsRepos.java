package com.java.repos;

import com.java.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailsRepos extends JpaRepository<Details, String> {
}
