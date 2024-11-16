package com.emr.emrlite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BILL_SEQUENCE_GENERATOR")
public class BillSequenceGenerator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BILL_SEQ_GEN_ID")
	private Long billSequenceGeneratorId;

	@Column(name="SEQUENCE_NUMBER")
	private Long sequenceNumber;

}
