package pers.study.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : panxin
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = -5344850839929666943L;

    private Long id;

    private Long pid;

    private String name;

    private String code;

}
