package per.study.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : panxin
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jpa_user")
public class JpaUser implements Serializable{

    private static final long serialVersionUID = -7051052998122815616L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

}
