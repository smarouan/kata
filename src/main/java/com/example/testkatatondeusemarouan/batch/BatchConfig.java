package com.example.testkatatondeusemarouan.batch;


import com.example.testkatatondeusemarouan.model.Position;
import com.example.testkatatondeusemarouan.model.Tondeuse;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder.addScript("classpath:org/springframework/batch/core/schema-drop-h2.sql")
                .addScript("classpath:org/springframework/batch/core/schema-h2.sql")
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }
    @Bean
    public Job tondeuseJob(JobRepository jobRepository, Step tondeuseStep) {
        return new JobBuilder("tondeuseJob", jobRepository)
                .start(tondeuseStep)
                .build();
    }


    @Bean
    public Step tondeuseStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("tondeuseStep", jobRepository)
                .<String, Tondeuse>chunk(1, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    private ItemWriter<? super Tondeuse> writer() {
        return new ItemWriter<Tondeuse>() {
            @Override
            public void write(Chunk<? extends Tondeuse> chunk) throws Exception {
                System.out.println(chunk);
            }
        };
    }

    private ItemProcessor<? super String,? extends Tondeuse> processor() {
        return new ItemProcessor<>() {
            @Override
            public Tondeuse process(String item) throws Exception {
                return new Tondeuse(new Position(0,0, 'N'));
            }
        };
    }

    private ItemReader<String> reader() {
        FlatFileItemReader<String> reader = new FlatFileItemReader<>();
        reader.setResource(new PathResource("C:\\Projets\\testkata-tondeuse\\input.txt"));
        reader.setLineMapper(new PassThroughLineMapper());
        return reader;
    }

}
