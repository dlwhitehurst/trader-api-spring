package com.dlwhitehurst.tradetx.repository;

import com.dlwhitehurst.tradetx.model.Position;

import java.util.List;

public interface PositionRepositoryCustom {
    List<Position> findAllBySymbol(String symbol);
}
