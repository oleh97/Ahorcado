package es.babel.ahorcado.model.manager;

import es.babel.ahorcado.model.entities.Subject;
import es.babel.ahorcado.model.persistance.ThemeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeManager {

    @Autowired
    ThemeDao dao;

    public Subject insert(Subject t) {
        if(dao.findByTheme(t.getTheme()) == null) {
            return dao.save(t);
        }
        else return t;
    }

    public List<Subject> findAll() {
        return dao.findAll();
    }

    public Subject find(String name) {
        return dao.findByTheme(name);
    }

}
