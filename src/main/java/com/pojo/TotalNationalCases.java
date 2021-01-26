package com.pojo;

public class TotalNationalCases {

			private Integer srno;
			private String country;
			private Integer confirmed;
			private Integer active;
			private Integer recovered;
			private Integer death;
			
			public Integer getSrno() {
				return srno;
			}
			public void setSrno(Integer srno) {
				this.srno = srno;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public String getCountry() {
				return country;
			}
			public Integer getConfirmed() {
				return confirmed;
			}
			public void setConfirmed(Integer confirmed) {
				this.confirmed = confirmed;
			}
			public Integer getActive() {
				return active;
			}
			public void setActive(Integer active) {
				this.active = active;
			}
			public Integer getRecovered() {
				return recovered;
			}
			public void setRecovered(Integer recovered) {
				this.recovered = recovered;
			}
			public Integer getDeath() {
				return death;
			}
			public void setDeath(Integer death) {
				this.death = death;
			}
			@Override
			public String toString() {
				return "TotalNationalCases [srno=" + srno + ", country=" + country + ", confirmed=" + confirmed
						+ ", active=" + active + ", recovered=" + recovered + ", death=" + death + "]";
			}
			
			
		}

