package ch09;

// 임시저장소(좀 빠른 임시저장소)
// 일반 RDBMS는 좀 느린데,응답성능이 한 10ms
// 캐시 저장소는, 응답성능이 한 1ms

//문제 1: Cache라는 제네릭 클래스를 작성하세요. 이 클래스는 다음을 수행해야 합니다.
//클래스 이름: Cache
//제네릭 형식: T
//클래스 변수: data (제네릭 타입 T)
//제공되는 메소드: getData()와 setData(T data)
public class Cache<T> {
    private T data;

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
