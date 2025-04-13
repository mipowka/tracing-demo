# 🚀 tracing-demo

Демо-приложение на Spring Boot 3 с полной обсервабилити-инфраструктурой: **трейсинг, метрики, логирование** — всё в одном месте 💡

## 📦 Стек

| Компонент                             | Назначение                           |
|---------------------------------------|--------------------------------------|
| Spring Boot 3                         | Основное приложение                  |
| Micrometer Tracing                    | Распределённый трейсинг (Zipkin)     |
| Prometheus                            | Сбор метрик                           |
| Grafana                               | Дашборды для метрик                   |
| Zipkin                                | Отображение распределённых трейсингов |
| ELK (Elasticsearch + Logstash + Kibana) | Централизованное логирование       |

---

## 🔧 Как запустить

### 🧱 1. Запусти инфраструктуру

```bash
docker-compose up -d
Проверь, чтобы порты 9200, 5000, 5601, 9411, 9090, 3000 не были заняты.

🚀 2. Запусти Spring Boot приложение
./mvnw spring-boot:run

🌐 Интерфейсы
Сервис	URL
Zipkin	http://localhost:9411
Prometheus	http://localhost:9090
Grafana	http://localhost:3000
Kibana	http://localhost:5601
Actuator Prometheus	http://localhost:8080/actuator/prometheus

📊 Grafana Dashboard
Перейди в Grafana: http://localhost:3000
Логин/пароль по умолчанию: admin / admin
Добавь Prometheus как Data Source: http://prometheus:9090
Импортируй готовый Spring Boot Dashboard: ID 4701

📥 Kibana
Перейди в http://localhost:5601
Создай Index Pattern: springboot-logs-*
Перейди в Discover — увидишь структурированные логи

🔁 Пример логов и трейсинга
Каждый HTTP-запрос генерирует:
🎯 Trace ID и Span ID
💬 JSON-логи, отправляемые в Logstash
📈 Метрики в Prometheus
🧵 Трейсы в Zipkin

🛠 Конфигурация
🔥 logback-spring.xml
<destination>localhost:5000</destination>
<encoder class="net.logstash.logback.encoder.LogstashEncoder">
  <customFields>{"app_name":"tracing-demo"}</customFields>
</encoder>

🎯 application.yml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
  metrics:
    export:
      prometheus:
        enabled: true

📚 Полезные команды
# Очистить образы
docker system prune -af

# Перезапуск только инфраструктуры
docker-compose restart

🧑‍💻 Автор
Made with ❤️ by @mipowka