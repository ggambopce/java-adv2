# java-adv2

### TCP 전송 제어 프로토콜  
- 연결 지향 - tcp 3 way handshake  
- 데이터 전달 보증
- 순서보장
- 신뢰할 수 있는 프로토콜

### TCP 3 way handshake
SYN: 접속요청  
ACK: 요청수락  
1. SYN
2. SYN + ACK
3. ACK

### UDP 특징 

- 연결지향 x
- 데이터 전달 보증 x
- 순서보장 x
- 단순하고 빠름
- 실시간 전송에 유리

### C 와 JAVA의 바이트순서(byte order, 엔디안) 관리
네트워크 표준 : 빅엔디안

| 항목               | C                                          | Java                                   |
| ---------------- | ------------------------------------------ | -------------------------------------- |
| 기본 바이트 순서        | 하드웨어 의존 (대부분 리틀엔디안)                        | **JVM 강제 빅엔디안**                        |
| 네트워크 바이트 순서 처리   | **개발자가 명시적으로 변환해야 함**                      | JVM이 자동으로 네트워크 표준 빅엔디안 사용              |
| API 예            | `htons()`, `htonl()`, `ntohs()`, `ntohl()` | 없음 (ex: `DataOutputStream.writeInt()`) |
| 직렬화 시 바이트 순서 고려  | 반드시 고려해야 함                                 | 고려하지 않아도 됨                             |
| TCP 통신 데이터 해석    | 바이트 순서를 수동으로 맞춰야 정확히 해석됨                   | JVM 내부에서 자동으로 맞춰줌                      |
| 장치 간 통신 시 호환성 문제 | 엔디안이 다르면 **오류 발생 위험 있음**                   | JVM이 일관되게 처리하므로 호환성 문제 적음              |

