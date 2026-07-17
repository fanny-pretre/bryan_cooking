import Box from "@mui/material/Box";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";

import banner from "../assets/banner.png";

export default function MealCardPlanning() {
  return (
    <Card
      sx={{
        display: "flex",
        width: "100%",
        overflow: "hidden",
      }}
    >
      <Box
        sx={{
          flex: 1,
          minWidth: 0,
        }}
      >
        <CardContent>
          <Typography
            component="h3"
            variant="h6"
            sx={{
              fontWeight: 600,
            }}
          >
            Jour
          </Typography>

          <Box
            sx={{
              display: "flex",
              flexDirection: "column",
              gap: 1,
            }}
          >
            <Box
              sx={{
                display: "flex",
                gap: 1,
                overflow: "hidden",
              }}
            >
              <Typography
                variant="subtitle1"
                sx={{
                  color: "text.secondary",
                }}
              >
                M
              </Typography>

              <Typography variant="subtitle1" noWrap>
                Nom plat
              </Typography>
            </Box>

            <Box
              sx={{
                display: "flex",
                gap: 1,
                overflow: "hidden",
              }}
            >
              <Typography
                variant="subtitle1"
                sx={{
                  color: "text.secondary",
                }}
              >
                S
              </Typography>

              <Typography variant="subtitle1" noWrap>
                Nom plat
              </Typography>
            </Box>
          </Box>
        </CardContent>
      </Box>

      <CardMedia
        component="img"
        sx={{
          width: 80,
          height: 80,
          flexShrink: 0,
          objectFit: "cover",
          alignSelf: "center",
          mr: 1,
          borderRadius: 1,
        }}
        image={banner}
        alt="plat midi"
      />

      <CardMedia
        component="img"
        sx={{
          width: 80,
          height: 80,
          flexShrink: 0,
          objectFit: "cover",
          alignSelf: "center",
          mr: 1,
          borderRadius: 1,
        }}
        image={banner}
        alt="plat soir"
      />
    </Card>
  );
}
