package com.test.json.compare.app.repository;

import com.test.json.compare.app.model.BaseContentDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JSONCrudRepo extends CrudRepository<BaseContentDO, Integer> {

}
