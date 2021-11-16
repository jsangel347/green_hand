
package co.edu.poli.greenhand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.poli.greenhand.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String userName);
}
