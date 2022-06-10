package com.softete.followpolitical.rest.api.repository;

import com.softete.followpolitical.rest.api.Model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
}
