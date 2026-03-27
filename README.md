# Distributed Scheduler Practice (2026.03)

## 주제
- 분산 환경에서 Scheduler + Batch 구현 (Shedlock / Quartz / Spring Batch)

## 목적
- 중복 실행 방지
- Batch 구조 이해
- 메시지 / 스케줄 / 배치 흐름 이해

## 기술 스택
![Java](https://img.shields.io/badge/Java-25-red)
![Spring](https://img.shields.io/badge/SpringBoot-green)
![Quartz](https://img.shields.io/badge/Quartz-orange)
![Batch](https://img.shields.io/badge/SpringBatch-yellow)
![MySQL](https://img.shields.io/badge/MySQL-blue)
![Docker](https://img.shields.io/badge/Docker-blue)

## 구조
Scheduler → Batch → Processor → DB

## 목적
- 멀티 인스턴스 환경 제어
- 멱등성 처리
- 분산락 구현
