package com.spring.toyproject.repository.base;

import com.spring.toyproject.domain.entity.Trip;
import com.spring.toyproject.domain.entity.User;
import com.spring.toyproject.repository.custom.TripRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Long>, TripRepositoryCustom {

    // 사용자별 여행 존재 여부 확인
    boolean existsByUserAndTitle(User user, String title);

    // 사용자별 여행 ID로 조회 (보안을 위해 사용자 정보도 함께 확인)
    Optional<Trip> findByIdAndUser(Long id, User user);
}