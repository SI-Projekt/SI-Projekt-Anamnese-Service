package thb.siprojektanamneseservice.search.specs;
import org.springframework.data.jpa.domain.Specification;
import thb.siprojektanamneseservice.model.Person;
import thb.siprojektanamneseservice.model.Person_;
import thb.siprojektanamneseservice.search.criteria.PersonCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class PersonSpecs implements Specification<Person> {
    private static final long serialVersionUID = -3867762911552315211L;

    private final PersonCriteria criteria;

    public PersonSpecs(PersonCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<Predicate>();

        // by name: firstname or lastname:
        if (criteria.getName() != null) {
            Predicate firstNameOrlastNamePredicate = criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.upper(root.get(Person_.firstName)),
                            "%" + criteria.getName().toUpperCase() + "%"),
                    criteriaBuilder.like(criteriaBuilder.upper(root.get(Person_.lastName)),
                            "%" + criteria.getName().toUpperCase() + "%"));

            predicates.add(firstNameOrlastNamePredicate);
        }

        // by userName:
        if (criteria.getUserName() != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get(Person_.userName)),
                    "%" + criteria.getUserName().toUpperCase() + "%"));
        }

        criteriaQuery.distinct(true);
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }

}
