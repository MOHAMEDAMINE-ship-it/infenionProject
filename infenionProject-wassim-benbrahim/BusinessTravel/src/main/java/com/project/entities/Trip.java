package com.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@Table(name = "Trip")
public class Trip  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdTrip;
	private String Domain;
private String Destination;
private String Duration;

@Temporal(TemporalType.DATE)
@Column(name = "DateBegin")
private Date DateBegin;
@Temporal(TemporalType.DATE)
@Column(name = "DateEnd")
private Date DateEnd;
private	int CodeMatche;
	@JsonIgnore
	@ManyToOne
	User usertrip;}