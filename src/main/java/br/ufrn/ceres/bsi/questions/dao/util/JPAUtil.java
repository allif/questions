package br.ufrn.ceres.bsi.questions.dao.util;

import javax.persistence.*;

public class JPAUtil {

    public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("questionsPU");

}
