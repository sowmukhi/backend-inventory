//package com.example.inventorydemo.createroom.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "rateplans",schema = "roomdetails_db")
//public class RatePlanEntity {
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    private Long id;
//    @Column(name = "rateplanename")
//    private String ratePlanName;
//    @Column(name = "mealplan")
//    private String mealPlan;
//
//    @ManyToOne
//    @JoinColumn(name = "room_id")
//    private RoomDetailsEntity room;
//}
