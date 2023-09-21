package com.amdocs.CargoManagementSystem.entity;


	
	import java.util.Date;

	import org.springframework.format.annotation.DateTimeFormat;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
	import javax.persistence.TemporalType;
	//import lombok.AllArgsConstructor;
	//import lombok.Data;
	//import lombok.NoArgsConstructor;

	//@NoArgsConstructor
	//@AllArgsConstructor
	//@Data
	@Entity
	public class Truck {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "tnno")
		private long tnno;
		
		@Column(name = "vehicle_number")
		private String vehicle_number;
		
		
		@Column(name = "truck_name")
		private String truck_name;
		
		@Column(name = "manufactureDate")
		@DateTimeFormat(pattern = "yyyy-mm-dd")
		@Temporal(TemporalType.DATE)
		private Date manufactureDate;
		
		@Column(name = "weight")
		private int weight;
	
		@ManyToOne
	    @JoinColumn(name = "cno")
		private Cargo cargo;

		public long getTnno() {
			return tnno;
		}

		public void setTnno(long tnno) {
			this.tnno = tnno;
		}

		public String getVehicle_number() {
			return vehicle_number;
		}

		public void setVehicle_number(String vehicle_number) {
			this.vehicle_number = vehicle_number;
		}

		public String getTruck_name() {
			return truck_name;
		}

		public void setTruck_name(String truck_name) {
			this.truck_name = truck_name;
		}

		public Date getManufactureDate() {
			return manufactureDate;
		}

		public void setManufactureDate(Date manufactureDate) {
			this.manufactureDate = manufactureDate;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public Cargo getCargo() {
			return cargo;
		}

		public void setCargo(Cargo cargo) {
			this.cargo = cargo;
		}

		public Truck(long tnno, String vehicle_number, String truck_name, Date manufactureDate, int weight,
				Cargo cargo) {
			super();
			this.tnno = tnno;
			this.vehicle_number = vehicle_number;
			this.truck_name = truck_name;
			this.manufactureDate = manufactureDate;
			this.weight = weight;
			this.cargo = cargo;
		}

		public Truck() {
			super();
		}
		
	
}
