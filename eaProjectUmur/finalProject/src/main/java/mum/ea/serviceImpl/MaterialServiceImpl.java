package mum.ea.serviceImpl;

import mum.ea.dao.MaterialDao;
import mum.ea.domain.Material;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialDao materialDao;

    public EaResult save(Material t) {
        return  materialDao.save(t);
    }

    public EaResult delete(Long id) {
       return materialDao.delete(id);
    }

    public EaResult update(Material t) {
       return materialDao.update(t);
    }

    public EaResultData<Material> findById(Long id) {
        return materialDao.findById(id);
    }

    public EaResultData<List<Material>> findAll() {
        return materialDao.findAll();
    }
}
