package com.dlwhitehurst.tradetx.repository;

import com.dlwhitehurst.tradetx.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepositoryBasic extends JpaRepository<Position, Long> {
}
