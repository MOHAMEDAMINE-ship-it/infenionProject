package com.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "user")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
    @Column(name = "name")
    private String name;
    @Column(name = "user_name")
    private String  username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    
    @ManyToMany(fetch = EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "id")
    private Collection<Role> roles = new ArrayList<>();
    @Enumerated(EnumType.STRING)
	EmployeeType  employeeType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="complainer")
	@JsonIgnore
	private List<Complaint> complaints;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="complainedAbout")
	@JsonIgnore
	private List<Complaint> complaintsrecieved;
	@OneToOne()
	@JsonIgnore
	private ResponseComplaint response;
    
    @Override
	public String toString() { return "User [id_user=" + id + ", first_name=" + first_name + ", last_name=" + last_name +", email=" + email +", password=" + password +", roles=" + roles + "]"; }

   
}
